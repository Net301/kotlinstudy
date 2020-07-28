fun main(args: Array<String>) : Unit {
    // Printing Hello World
    print("Hello World\n");
    // Hello world with a printer
    Printer("Hello World").print();
    // Using List
    Printer(NizarList(1, null).add(5).map {it+4}.toString()).print();
    
}

//Defining a printer

class Printer(val what2print: String) {
    fun print():Unit {
        print (this.what2print+"\n");
        return
    }
}

//Defining a List Data Structure

data class NizarList(val first:Int, val rest:NizarList?) {

    fun add(elm:Int):NizarList {
        return NizarList(elm, this)
    }

    override fun toString():String {
        return this.first.toString() + " "+ (rest?.toString() ?: "");
    }

    fun map(mapFun: (a:Int)-> Int ):NizarList {
        return NizarList(mapFun(first), rest?.map(mapFun)?:null)
    }

    fun getFirstElement ():Int {
        return first;
    }
    fun getTheRest ():NizarList? {
        return rest;
    }

}

operator fun NizarList.component1():Int {
    return this.getFirstElement();
}

operator fun NizarList.component2():NizarList? {
    return this.getTheRest();
}

