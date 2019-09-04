namespace FizzBuzz.Domain
{
    public class FizzBuzz
    {
        public static int[] Print1From100()
        {
            var list = new int[100];
            for (var i = 1; i <= 100; i++)
            {
                list[i - 1] = i;
            }
            return list;
        }
    }
}