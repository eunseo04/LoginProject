<img width="994" height="518" alt="image" src="https://github.com/user-attachments/assets/46f2e33e-6367-4ebd-9aa4-c1c2150b2c0c" />

GET 기능
--------------------------------------------
+ 메서드 	GET / http://localhost:8080/users
+ 기능 	회원 전체 조회
+ 매개변수 	X
+ 응답 	UserResponse  (JSON)
---------------------------------------------
+ 메서드 	GET / http://localhost:8080/todo
+ 기능 	todo 전체 조회
+ 매개변수 	X
+ 응답 	TodoResponse (JSON)
---------------------------------------------
+ 메서드 	GET / http://localhost:8080/comments
+ 기능 	댓글 전체 조회
+ 매개변수 	X
+ 응답 	CommentResponse (JSON)
---------------------------------------------
+ 메서드 	GET / http://localhost:8080/users/{userId}
+ 기능 	id와 일치하는 회원 조회
+ 매개변수 	userId (Long, @PathVariable)
+ 응답 	UserResponse  (JSON)
---------------------------------------------
+ 메서드 	GET / http://localhost:8080/todo/{todoId}
+ 기능 	id와 일치하는 todo 조회
+ 매개변수 	todoId (Long, @PathVariable)
+ 응답 	JSON
---------------------------------------------
+ 메서드 	GET / http://localhost:8080/users/{userId}/comments
+ 기능 	id와 일치하는 회원이 작성한 댓글 조회
+ 매개변수 	userId (Long, @PathVariable)
+ 응답 	JSON
---------------------------------------------


POST 기능
---------------------------------------------
+ 메서드	POST / http://localhost:8080/signIn
+ 기능	로그인
+ 매개변수 / 요청 Body 	UserRequest(@RequestBody) / HttpServletRequest
+ 응답	ResponseEntity (JSON)
---------------------------------------------
+ 메서드	POST / http://localhost:8080/signUp
+ 기능	회원가입
+ 매개변수 / 요청 Body 	UserRequest(@RequestBody) / HttpServletRequest
+ 응답	UserResponse (JSON)
---------------------------------------------
+ 메서드	POST / http://localhost:8080/logout
+ 기능	로그아웃
+ 매개변수 / 요청 Body 	UserRequest(@RequestBody) / HttpServletRequest
+ 응답	void
---------------------------------------------
+ 메서드	POST / http://localhost:8080/todo
+ 기능	todo 생성
+ 매개변수 / 요청 Body 	TodoRequest(@RequestBody) / UserEntity
+ 응답	TodoResponse (JSON)
---------------------------------------------
+ 메서드	POST / http://localhost:8080/todo/{todoId}/comments
+ 기능	댓글 생성
+ 매개변수 / 요청 Body 	todoId (Long, @PathVariable) / CommentRequest(@RequestBody) / UserEntity
+ 응답	CommentResponse (JSON)
---------------------------------------------


PATCH 기능
---------------------------------------------
+ 메서드	PATCH / http://localhost:8080/users/{userId}
+ 기능	회원 정보 수정
+ 매개변수 / 요청 Body 	userId (Long, @PathVariable) / UserEntity / UserRequest(@RequestBody)
+ 응답	UserResponse (JSON)
---------------------------------------------
+ 메서드	PATCH / http://localhost:8080/todo/{todoId}
+ 기능	todo 정보 수정
+ 매개변수 / 요청 Body 	todoId (Long, @PathVariable) / TodoRequest(@RequestBody)
+ 응답	TodoResponse (JSON)
---------------------------------------------
+ 메서드	PATCH  / http://localhost:8080/comments/{commentId}
+ 기능	댓글 정보 수정
+ 매개변수 / 요청 Body 	commentId (Long, @PathVariable) / CommentRequest(@RequestBody)
+ 응답	CommentResponse (JSON)
---------------------------------------------


DELETE 기능
---------------------------------------------
+ 메서드	DELETE /  http://localhost:8080/users/{userId}
+ 기능	회원 탈퇴
+ 매개변수	id (Long, PathVariable)
+ 응답	void
---------------------------------------------
+ 메서드	DELETE  / http://localhost:8080/todo/{todoId}
+ 기능	todo 삭제
+ 매개변수	id (Long, PathVariable) 
+ 응답	void
---------------------------------------------
+ 메서드	DELETE  / http://localhost:8080/comments/{commentId}
+ 기능	댓글 삭제
+ 매개변수	id (Long, PathVariable)
+ 응답	void
---------------------------------------------
