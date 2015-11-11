<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
<h3>Choose a file to upload</h3>
</body>

<form:form method="post" action="submit"
        modelAttribute="uploadForm" enctype="multipart/form-data">
  
    <p>Select files to upload..</p>
  
         <input name="files[0]" type="file" />
         <form:errors path="files" cssstyle="color: red;"></form:errors>
    <br/><input type="submit" value="Upload" />
</form:form>
</body>
</html>