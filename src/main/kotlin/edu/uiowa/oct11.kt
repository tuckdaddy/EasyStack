package edu.uiowa

class StackError(): Error()  // subtype of Error, just for Stack
interface Stack<T> {
   val size: Int  // the stack's current number of elements
   val isEmpty: Boolean // true if the stack is empty
   fun clear()    // empty the stack entirely
   // both peek() and pop() throw StackError when stack is empty
   fun peek(): T  // return value on top of Stack
   fun pop(): T   // return element on top, plus remove that element
   fun push(item:T)  // push new item on top of stack
   fun hasElem(value:T): Boolean // return true if stack contains value
   }

class EasyStack<T>(): Stack<T> {
    private val data = mutableListOf<T>()

    private val empty get() = size == 0 // for convenience

    override val size: Int get() = data.size

    override val isEmpty: Boolean get() = data.isEmpty()

    override fun clear() {
        data.clear()
    }

    override fun peek(): T {
        if (empty) throw StackError()
        return data[data.lastIndex]
    }

    override fun pop(): T {
        if (empty) throw StackError()
        return data.removeAt(data.lastIndex)
    }

    override fun push(item: T) {
        data.add(item)
    }

    override fun hasElem(value: T): Boolean {
      //var res:Boolean = {x:Int -> data[x]; if(value == data[x]) }
        val yep = data.contains(value)
        return yep

    }
}

interface Tokenizer {
   fun addSymbol(s:String) // add symbol pair to Parser
   fun tokenize(input:String): List<String> // break apart
       // input into list of Strings separated by
       // (1) whitespace, and (2) symbols added previously
   }

class EasyTokenizer(): Tokenizer {
    val token = mutableListOf<String>()
    var final= listOf<String>()
    var currToken:String = " "


    override fun addSymbol(s: String) {
       token.add(s)
       // println("This is toke $token")
    }


//need to zip, map, then flatten, then sublist, final list will be twice the size
    override fun tokenize(input: String): List<String>{
        if(input.isEmpty()){
            val t:List<String> = mutableListOf()
            return t
        }
        for( i in token){
            println("This is i $i")
            println("This is input trim " +input.trim())
            if(input.contains(i)){
                final = input.split(i)
                val words = final.joinToString(i)
                println("This is words $words")
              //for(ele in input)
            }
        }










        //var parse:List<String> = mutableListOf()
        //var final: List<String> = mutableListOf<String>()
        //for(token in token) {
         //   if(input.contains(token)){
         //       parse = input.trim().split(token)
         //       println("This is parse $parse")
         //       currToken = token
         //       println("This is current token $currToken")
        //        for(e in parse){
        //            println("this is e $e")
        //            final.add(e)

         //       }
        //    }
       // }
       // val p = final.zip(token).map{it}

   // final.removeAt(final.lastIndex)
        return final
    }
   // write code here
   }

