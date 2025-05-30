package dsa.array

class PascalTriangleKt {

    companion object{
        @JvmStatic
        fun generate(numRows: Int): List<List<Int>> {
            val pascalTriangle : MutableList<MutableList<Int>> = mutableListOf<MutableList<Int>>()
            for( i in 1..numRows){
              pascalTriangle.add(getPascalRow(i));
            }
            return pascalTriangle;
        }

        @JvmStatic
        private fun getPascalRow(n:Int):MutableList<Int>{
            val row = mutableListOf<Int>()
            row.add(1);
            for(i in 1 until n){
                var value = row[i-1]*(n-i)
                value = value/i;
                row.add(value);
            }
            return row;
        }
    }
}