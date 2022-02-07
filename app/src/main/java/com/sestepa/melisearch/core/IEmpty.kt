package com.sestepa.melisearch.core

interface IEmpty {

	fun isEmpty(): Boolean
	fun isNotEmpty(): Boolean = !isEmpty()
}
