<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	 <style>
	 h1{
	    text-align: center;
	    width: 100%;
	    border:solid black;
	    border-radius: 10px;
	    background-color: rgb(201, 238, 238);
	    }
	  form {
		  max-width: 600px;
		  margin: 0 auto;
		  padding: 20px;
		  background-color: #f5f5f5;
		  border-radius: 5px;
		  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		}
		
		label {
		  display: block;
		  font-weight: bold;
		  margin-bottom: 5px;
		}
		
		input[type="text"],
		textarea {
		  width: 100%;
		  padding: 10px;
		  border: 1px solid #ccc;
		  border-radius: 3px;
		  font-size: 16px;
		  margin-bottom: 15px;
		}
		
		textarea {
		  height: 150px;
		  resize: vertical;
		}
		
		button {
		  display: inline-block;
		  background-color: #4CAF50;
		  color: white;
		  padding: 10px 20px;
		  border: none;
		  border-radius: 3px;
		  cursor: pointer;
		  font-size: 16px;
		  margin-right: 10px;
		}
		
		button[type="reset"] {
		  background-color: #f44336;
		}
		
		button:hover {
		  opacity: 0.8;
		}  
	 </style>
</head>
<body>
<h1>
	글 등록 
</h1>

<form name="create" action="insertok" method="post">
  <label>제목</label>
  <input type="text" name="title" />
  <br>
  <label>내용</label>
  <textarea type="text" name="content" >
  </textarea>
  <br>
  <button type="submit">전송</button>
  <button type="reset">취소</button>
  
</form>
</body>
</html>
