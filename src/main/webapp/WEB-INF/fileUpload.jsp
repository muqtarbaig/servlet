<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
<h3>Choose a file to upload</h3>
</body>

<form:form method="post" action="submit"
        modelAttribute="uploadForm" enctype="multipart/form-data">
  
    <p>Select files to upload..</p>
  
         <input name="myFile" type="file" />
    <br/><input type="submit" value="Upload" />
</form:form>
</body>
</html>