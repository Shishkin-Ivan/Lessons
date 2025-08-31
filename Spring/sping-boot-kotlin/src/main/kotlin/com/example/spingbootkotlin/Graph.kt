package com.example.spingbootkotlin

class Graph {
    private val adjList: MutableMap<Int, MutableList<Int>> = HashMap()

    fun addVertex(v: Int) {
        adjList[v] = ArrayList()
    }

    fun addEdge(v: Int, w: Int) {
        adjList[v]!!.add(w)
        adjList[w]!!.add(v)
    }

    fun removeVertex(v: Int) {
        for (i in adjList.keys) {
            if (adjList[i]!!.contains(v)) {
                for (j in adjList[i]!!.indices) {
                    if (adjList[i]!![j] == v) {
                        adjList[i]!!.removeAt(j)
                    }
                }
            }
        }
        adjList.remove(v)
    }

    fun removeEdge(v: Int, w: Int) {
        adjList[v]!!.remove(w)
        adjList[w]!!.remove(v)
    }

    fun printGraph() {
        for (v in adjList.keys) {
            println(v.toString() + " -> " + adjList[v])
        }
        println()
    }
}