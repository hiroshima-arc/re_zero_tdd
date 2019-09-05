using System;
using FizzBuzz.Application.Command;

namespace FizzBuzz.Domain.Type
{
    public abstract class FizzBuzzType: Enumeration
    {
        public static FizzBuzzType One = new FizzBuzzType01();
        public static FizzBuzzType Two = new FizzBuzzType02();
        public static FizzBuzzType Three = new FizzBuzzType03();
        
        public static readonly string FIZZ = "Fizz";
        public static readonly string BUZZ = "Buzz";
        public static readonly string FIZZ_BUZZ = "FizzBuzz";
        public abstract IFizzBuzz Generate(int number);
    }
    public abstract class Enumeration : IComparable
    {
        public int CompareTo(object obj)
        {
            throw new NotImplementedException();
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(this, obj))
            {
                return true;
            }

            if (ReferenceEquals(obj, null))
            {
                return false;
            }

            throw new NotImplementedException();
        }

        public override int GetHashCode() => throw new NotImplementedException();

        public static bool operator ==(Enumeration left, Enumeration right)
        {
            if (ReferenceEquals(left, null))
            {
                return ReferenceEquals(right, null);
            }

            return left.Equals(right);
        }

        public static bool operator !=(Enumeration left, Enumeration right)
        {
            return !(left == right);
        }

        public static bool operator <(Enumeration left, Enumeration right)
        {
            return ReferenceEquals(left, null) ? !ReferenceEquals(right, null) : left.CompareTo(right) < 0;
        }

        public static bool operator <=(Enumeration left, Enumeration right)
        {
            return ReferenceEquals(left, null) || left.CompareTo(right) <= 0;
        }

        public static bool operator >(Enumeration left, Enumeration right)
        {
            return !ReferenceEquals(left, null) && left.CompareTo(right) > 0;
        }

        public static bool operator >=(Enumeration left, Enumeration right)
        {
            return ReferenceEquals(left, null) ? ReferenceEquals(right, null) : left.CompareTo(right) >= 0;
        }
    }
}