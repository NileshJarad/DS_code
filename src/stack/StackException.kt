package stack

import java.lang.Exception

class StackEmptyException : Exception("Stack is empty.")

class StackFullException : Exception("Stack is full.")