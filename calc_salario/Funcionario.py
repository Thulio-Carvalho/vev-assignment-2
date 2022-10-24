class Funcionario:
    def __init__(self, nome, email, salario_base, cargo):
        self.nome = nome
        self.email = email
        self.salario_base = salario_base
        self.cargo = cargo.lower() 

    def salario_liq(self):
        if self.cargo == 'desenvolvedor':
            if self.salario_base >= 3000: return self.salario_base * (1.0 - 0.2)
            return self.salario_base * (1.0 - 0.1)