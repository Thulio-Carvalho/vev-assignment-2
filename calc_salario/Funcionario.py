import re

class Funcionario:
    def __init__(self, nome, email, salario_base, cargo):
        self.nome = nome
        self.email = email
        self.salario_base = salario_base
        self.cargo = cargo
        
        self.__validate_creation_parameters()
        self.cargo = self.cargo.lower()

        self.DISCOUNT_RATE = {
            'desenvolvedor': {
                'base_val_threshold': 3000,
                'lt_discount': 0.1,
                'gte_discount': 0.2
            }
        }

    def __validate_creation_parameters(self):
        VALID_CARGOS = [
            'desenvolvedor'
        ]

        def __string_input_validation(value):
            if not isinstance(value, str): raise TypeError
            if value.strip() == '': raise AttributeError

        [__string_input_validation(value) for value in [
            self.cargo,
            self.nome
        ]]

        if self.cargo.lower() not in VALID_CARGOS: raise AttributeError

        email_regex = re.compile(r'([A-Za-z0-9]+[.-_])*[A-Za-z0-9]+@[A-Za-z0-9-]+(\.[A-Z|a-z]{2,})+')

        def __isEmailValid(email):
            if not re.fullmatch(email_regex, email): raise AttributeError
        
        __isEmailValid(self.email)

    def salario_liq(self):
        is_base_lower_than_threshold = self.salario_base < self.DISCOUNT_RATE[self.cargo]['base_val_threshold']
        def __lt_sallary(salario_base): 
            return salario_base * (1.0 - self.DISCOUNT_RATE[self.cargo]['lt_discount'])
        def __gte_sallary(salario_base): 
            return salario_base * (1.0 - self.DISCOUNT_RATE[self.cargo]['gte_discount'])

        if is_base_lower_than_threshold:
            return __lt_sallary(self.salario_base)
        return __gte_sallary(self.salario_base)