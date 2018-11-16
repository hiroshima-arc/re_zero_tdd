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


if __name__ == "__main__":
    unittest.main()
