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
    
    def test_invalid_cargo(self):
        with self.assertRaises(TypeError):
            funcionario = Funcionario("João", "joao@example.com", 1, 0)
            
        with self.assertRaises(AttributeError):
            funcionario = Funcionario("João", "joao@example.com", 1, "dev")

    def test_invalid_name(self):
        with self.assertRaises(TypeError):
            funcionario = Funcionario(0, "joao@example.com", 1, "desenvolvedor")
            
        with self.assertRaises(AttributeError):
            funcionario = Funcionario("", "joao@example.com", 1, "desenvolvedor")

if __name__ == '__main__':
    unittest.main()