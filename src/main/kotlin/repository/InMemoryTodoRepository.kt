package repository

import entities.Todo
import entities.TodoDraft

class InMemoryTodoRepository : TodoRepository
{
    private val todos = mutableListOf<Todo>(
        Todo(1,"Task#1",false),
        Todo(2,"Task#2",false),
        Todo(3,"Task#3",false),
    )
    override fun getAllTodos(): List<Todo> {
        return todos
    }

    override fun getTodo(id: Int): Todo? {
        return todos.firstOrNull { it.id == id }
    }

    override fun addTodo(draft: TodoDraft): Todo {
        val todo = Todo(
            id=todos.size+1,
            title=draft.title,
            done=draft.done
        )

        todos.add(todo)
        return todo
    }

    override fun updateTodo(id: Int, draft: TodoDraft): Boolean
        {
            val todo = todos.firstOrNull { it.id == id } ?: return false;

            todo.title = draft.title
            todo.done = draft.done
            return true
        }

}