package com.kmii.vue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	
//	private final TodoRepository todoRepository;     -> autowired 대신 이렇게도 쓸 수 있다.
//	public TodoController(TodoRepository todoRepository) {
//		this.todoRepository = todoRepository;
//	}
	
	
	
	// 모든 할일(todo) 리스트 조회 
	@GetMapping
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();		
	}
	
	
	// 할일 추가	
	@PostMapping
	public Todo addTodo(@RequestBody Todo todo){
		
		return todoRepository.save(todo);	
	}
	
	
	// 할일 삭제 -> id를 전달 받아 삭제
	@DeleteMapping("/{id}")  // 삭제할 todo id
	public void deleteTodo(@PathVariable("id") Long id) {
		todoRepository.deleteById(id);
	}
	
}
