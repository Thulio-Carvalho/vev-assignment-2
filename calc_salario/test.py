import unittest
from Funcionario import Funcionario

class TestCalculator(unittest.TestCase):
    def test_dev_higher(self):
        salario_base = 3000
        salario_liq_esperado = salario_base * (1.0 - 0.2)
        funcionario = Funcionario("João", "joao@example.com", salario_base, "DESENVOLVEDOR")
        self.assertEqual(funcionario.salario_liq(),
                        salario_liq_esperado,
                        f'Deveria ser {salario_liq_esperado}')

    def test_dev_lower(self):
        salario_base = 2999
        salario_liq_esperado = salario_base * (1.0 - 0.1)
        funcionario = Funcionario("João", "joao@example.com", salario_base, "DESENVOLVEDOR")
        self.assertEqual(funcionario.salario_liq(),
                        salario_liq_esperado,
                        f'Deveria ser {salario_liq_esperado}')

    def test_dba_higher(self):
        salario_base = 2000
        salario_liq_esperado = salario_base * (1.0 - 0.25)
        funcionario = Funcionario("João", "joao@example.com", salario_base, "DBA")
        self.assertEqual(funcionario.salario_liq(),
                        salario_liq_esperado,
                        f'Deveria ser {salario_liq_esperado}')

    def test_dba_lower(self):
        salario_base = 1999
        salario_liq_esperado = salario_base * (1.0 - 0.15)
        funcionario = Funcionario("João", "joao@example.com", salario_base, "DBA")
        self.assertEqual(funcionario.salario_liq(),
                        salario_liq_esperado,
                        f'Deveria ser {salario_liq_esperado}')
    
    def test_testador_higher(self):
        salario_base = 2000
        salario_liq_esperado = salario_base * (1.0 - 0.25)
        funcionario = Funcionario("João", "joao@example.com", salario_base, "TESTADOR")
        self.assertEqual(funcionario.salario_liq(),
                        salario_liq_esperado,
                        f'Deveria ser {salario_liq_esperado}')

    def test_testador_lower(self):
        salario_base = 1999
        salario_liq_esperado = salario_base * (1.0 - 0.15)
        funcionario = Funcionario("João", "joao@example.com", salario_base, "TESTADOR")
        self.assertEqual(funcionario.salario_liq(),
                        salario_liq_esperado,
                        f'Deveria ser {salario_liq_esperado}')

    def test_invalid_cargo(self):
        with self.assertRaises(TypeError):
            Funcionario("João", "joao@example.com", 1, 0)
            
        with self.assertRaises(AttributeError):
            Funcionario("João", "joao@example.com", 1, "dev")

    def test_invalid_name(self):
        with self.assertRaises(TypeError):
            Funcionario(0, "joao@example.com", 1, "desenvolvedor")
            
        with self.assertRaises(AttributeError):
            Funcionario("", "joao@example.com", 1, "desenvolvedor")
    
    def test_valid_email(self):    
        valid_emails = [
            "name.surname@gmail.com",
            "anonymous123@yahoo.co.uk",
        ]
        for email in valid_emails:
            Funcionario("Joao", email, 1, "desenvolvedor")

    def test_invalid_email(self):
         invalid_emails = [
            "anonymous123@...uk",
            "...@domain.us"
         ]
         for email in invalid_emails:
            with self.assertRaises(AttributeError):
                Funcionario("João", email, 1, 'desenvolvedor')
    
    def test_invalid_salario(self):
        with self.assertRaises(TypeError):
            Funcionario("João", "joao@example.com", "", "desenvolvedor")
        with self.assertRaises(AttributeError):
            Funcionario("João", "joao@example.com", -1, "desenvolvedor")
        with self.assertRaises(AttributeError):
            Funcionario("João", "joao@example.com", 0, "desenvolvedor")

if __name__ == '__main__':
    unittest.main()