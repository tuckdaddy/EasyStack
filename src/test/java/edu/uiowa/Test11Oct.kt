package edu.uiowa

import org.junit.Test
import org.junit.Assert.*
import kotlin.math.absoluteValue


class Oct11Test {
    @Test
    fun test1() {
        // create a very simple Stack
        val T: Stack<String> = EasyStack<String>()
        assertEquals(T.push("Hello"), kotlin.Unit)
        assertEquals(T.peek(), "Hello")
        assertEquals(T.size, 1)
        assertEquals(T.isEmpty, false)
        assertEquals(T.hasElem("Hello"), true)
        assertEquals(T.hasElem("hello"), false)
        assertEquals(T.pop(), "Hello")
        assertEquals(T.size, 0)
        assertEquals(T.isEmpty, true)
        assertEquals(T.hasElem("Hello"), false)
        }
    @Test(expected = StackError::class)
    fun test2() {
        // create empty stack and try to peek - should trigger StackError
        val T: Stack<String> = EasyStack<String>()
        assertEquals(T.peek(),"")
        }
    @Test(expected = StackError::class)
    fun test3() {
        // create empty stack and try to pop - should trigger StackError
        val T: Stack<String> = EasyStack<String>()
        assertEquals(T.pop(),"")
        }
    @Test
    fun test4() {
        // create and make stack with three items
        val T: Stack<String> = EasyStack<String>()
        T.push("Hello")
        T.push("to")
        T.push("everybody")
        var collect = ""  // use this later to collect pop()
        assertEquals(T.size,3)
        assertTrue(T.hasElem("to"))
        assertEquals(T.peek(),"everybody")
        collect = collect + T.pop()
        collect = collect + T.pop()
        collect = collect + T.pop()
        assertEquals(T.size,0)
        assertEquals(collect,"everybodytoHello")
        }
    @Test
    fun test10() {
        val E = EasyTokenizer()
        E.addSymbol("[")
        E.addSymbol("]")
        assertEquals(listOf<String>(),E.tokenize("")) // eddge case
        assertEquals(listOf("ab","[","cd"),E.tokenize("ab[cd"))
        assertEquals(listOf("[","hello","]"),E.tokenize("[hello]"))
        assertEquals(listOf("[","[","hello","]"),E.tokenize("[[hello]"))
        assertEquals(listOf("[","[","hello","]"),E.tokenize(" [[ hello ]"))
    }
    @Test
    fun test11() {
        val E = EasyTokenizer()
        E.addSymbol(";")
        E.addSymbol("-")
        E.addSymbol("---")
        val D = E.tokenize("abc;def-----xyz---lmn-o;-")
        val K = E.tokenize("abc ; def --- -- xyz--- lmn - o;-")
        assertEquals(D,K)
        }
    @Test
    fun test12() {
        val E = EasyTokenizer()
        E.addSymbol("*")
        E.addSymbol("**")
        E.addSymbol("+")
        E.addSymbol("++")
        val D = E.tokenize("f a5++big+n * d**35")
        assertEquals(listOf("f","a5","++","big","+","n","*","d","**","35"),D)
        }
    }
