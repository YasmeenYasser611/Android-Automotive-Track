package com.example.stars

fun main()
{
    print("Please Enter The num of rows if not enter it will be 4 by defult : ")
    var num = 4
    var input1 :String? = readln()
    if(!input1.isNullOrEmpty())
        num = input1!!.toInt()
    for(i in 0..num)
    {
        for(j in 0..2*num)
        {
            if(j<i)
                print("*");
            else
                print("")
        }
        for(j in 3*num-1 downTo  0 )
        {
            if( j< 2*i-1)
            {
                if(j %2 ==0)
                    print("*");
                else
                    print(" ");
            }
            else
                print(" ");
        }
        println()
    }
}