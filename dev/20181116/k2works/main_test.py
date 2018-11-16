import unittest


class ListTest(unittest.TestCase):
    def test_データとリスト(self):
        arr = [1, 2, 3, 4, 5]
        self.assertEqual([1, 2, 3, 4, 5], arr)

    def test_リストの値(self):
        arr = [1, 2, 3, 4, 5]
        self.assertNotEqual(0, arr[0])
        self.assertEqual(1, arr[0])
        self.assertEqual(5, arr[-1])

    def test_リストの演算(self):
        arr = [1, 2, 3] + [10, 20, 30]
        self.assertEqual([1, 2, 3, 10, 20, 30], arr)

        arr = [1, 2, 3] * 3
        self.assertEqual([1, 2, 3, 1, 2, 3, 1, 2, 3], arr)

    def test_値をリストにまとめる(self):
        arr = []
        a = '男'
        b = '女'
        c = '男'
        arr += [a] + [b] + [c]
        self.assertEqual(['男', '女', '男'], arr)

    def test_その他のシーケンス演算(self):
        arr = [10, 20, 30]
        self.assertTrue(10 in arr)
        self.assertTrue(0 not in arr)

        arr = [10, 20, 30, 40, 50]
        self.assertEqual([20, 30, 40], arr[1:4])
        self.assertEqual(5, len(arr))
        self.assertEqual(50, max(arr))
        self.assertEqual(10, min(arr))

    def test_リスト操作のメソッド(self):
        arr = [100, 200, 300]
        self.assertEqual([100, 200, 300], arr)

        arr.insert(1, 1000)
        self.assertEqual([100, 1000, 200, 300], arr)

        arr.remove(200)
        self.assertEqual([100, 1000, 300], arr)

        del arr[1]
        self.assertEqual([100, 300], arr)

        del arr
        arr = [100, 200, 300, 400, 500]
        arr.pop()
        arr.pop()
        arr.pop()
        self.assertEqual([100, 200], arr)

        arr.clear()
        self.assertEqual([], arr)

        arr = [100, 200, 300]
        arr.reverse()
        self.assertEqual([300, 200, 100], arr)

        arr = [10, 100, 1000, 20, 200, 2000, 30]
        arr.sort()
        self.assertEqual([10, 20, 30, 100, 200, 1000, 2000], arr)
        arr.sort(reverse=True)
        self.assertEqual([2000, 1000, 200, 100, 30, 20, 10], arr)

class TupleTest(unittest.TestCase):

    def test_タプルとは(self):
        tp = (10, 'a', True)
        self.assertEqual(10, tp[0])
        self.assertEqual('a', tp[1])
        self.assertTrue(tp[2])

    def test_ミュータブルとイミュータブル(self):
        arr = [10, 'a', True]
        tp = (10, 'a', True)

        arr[0] = 20
        self.assertEqual(20, arr[0])

        with self.assertRaises(TypeError) as ex:
            tp[0] = 20
        exception = ex.exception
        self.assertEquals(str(exception), "'tuple' object does not support item assignment")

    def test_タプルの算術演算(self):
        tp = (100, 'a') + (200, 'b')
        self.assertEqual((100, 'a', 200, 'b'), tp)

        tp = (100, 'a') * 3
        self.assertEqual((100, 'a', 100, 'a', 100, 'a'), tp)

        tp = (10, 'a')
        tp += (20, 'b')
        self.assertEqual((10, 'a', 20, 'b'), tp)
        tp *= 2
        self.assertEqual((10, 'a', 20, 'b', 10, 'a', 20, 'b'), tp)

    def test_タプルのシーケンス演算(self):
        tp = [10, 20, 30]
        self.assertTrue(10 in tp)
        self.assertTrue(0 not in tp)

        tp = [10, 20, 30, 40, 50]
        self.assertEqual([20, 30, 40], tp[1:4])
        self.assertEqual(5, len(tp))
        self.assertEqual(50, max(tp))
        self.assertEqual(10, min(tp))





if __name__ == "__main__":
    unittest.main()
