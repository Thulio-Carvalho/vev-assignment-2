import unittest

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

if __name__ == '__main__':
    unittest.main()