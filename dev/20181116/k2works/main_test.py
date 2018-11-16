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


class RangeTest(unittest.TestCase):

    def test_範囲を示すレンジ(self):
        rg = range(10)
        self.assertEqual(0, rg[0])
        self.assertEqual(9, rg[-1])

        rg = range(5, 10)
        self.assertEqual(5, rg[0])
        self.assertEqual(9, rg[-1])

        rg = range(10, 20, 2)
        self.assertEqual(12, rg[1])
        self.assertEqual(18, rg[-1])

    def test_レンジのシーケンス演算(self):
        rg = range(30)
        self.assertTrue(10 in rg)
        self.assertTrue(30 not in rg)

        rg = range(50)
        self.assertEqual(range(1, 4), rg[1:4])
        self.assertEqual(50, len(rg))
        self.assertEqual(49, max(rg))
        self.assertEqual(0, min(rg))

    def test_シーケンス間の変換(self):
        list1 = [100, 200, 300]
        tpl1 = (123, 'ok', True)
        rng1 = range(10, 20)
        result = list1 + list(tpl1) + list(rng1)
        self.assertEqual([100, 200, 300, 123, 'ok', True, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19], result)


class SetTest(unittest.TestCase):

    def test_セット値の利用(self):
        st = {'hi', 'hello', 'ok'}
        st.add('welcome')
        st.remove('ok')
        self.assertEqual({'hello', 'hi', 'welcome'}, st)
        self.assertTrue('hello' in st)
        self.assertTrue('ok' not in st)
        self.assertEqual(3, len(st))
        self.assertEqual('welcome', max(st))
        self.assertEqual('hello', min(st))

    def test_セットの演算(self):
        st1 = {10, 20, 30, 40, 50}
        st2 = {0, 20, 40, 60, 80}
        self.assertEqual({40, 20}, st1 & st2)
        self.assertEqual({0, 40, 10, 80, 50, 20, 60, 30}, st1 | st2)
        self.assertEqual({0, 10, 80, 50, 60, 30}, st1 ^ st2)
        self.assertEqual({10, 50, 30}, st1 - st2)


class DictTest(unittest.TestCase):

    def test_辞書とは(self):
        dc = {'a': 100, 'b': 200, 'c': 300}
        dc['d'] = 1000
        dc['a'] = dc['b'] + dc['c']
        self.assertEqual({'a': 500, 'b': 200, 'c': 300, 'd': 1000}, dc)
        del dc['a']
        self.assertEqual({'b': 200, 'c': 300, 'd': 1000}, dc)

    def test_キーワードと値の取得(self):
        dc = {'a': 100, 'b': 200, 'c': 300}
        self.assertEqual(['a', 'b', 'c'], list(dc.keys()))
        self.assertEqual([100, 200, 300], list(dc.values()))
        self.assertEqual([('a', 100), ('b', 200), ('c', 300)], list(dc.items()))


if __name__ == "__main__":
    unittest.main()
