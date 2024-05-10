# FileProcessing Documentation
 a leading environmental consulting firm, aims to develop a RESTful API to
 facilitate file data processing for their clients. The API will enable clients to upload text files
 containing environmental data for analysis and retrieve processed results through simple
 API requests and save the data in the database. As a software developer tasked with
 building this API, you need to design and implement a solution that meets the
 requirements outlined by Enviro365.

# Endpoints

# Description
This endpoint handles file uploads. It accepts a multipart file as input and processes it accordingly. Upon successful upload, it returns a success message. If there are any errors during the upload process, appropriate error messages are returned.

# Endpoint
POST http://localhost:8082/api/upload

# Request
Method: POST
URL: http://localhost:8082/api/upload
Request Body:
file (multipart): The file to be uploaded.

# Responses
Success Response (200 OK):
Body: "File uploaded successfully."
Description: Indicates that the file was uploaded successfully.
![Images]("./Images/fileUpload.png")

Error Responses:
Internal Server Error (500):
Body: "Failed to process the uploaded file."
Description: Indicates that there was an internal server error while processing the uploaded file.
Bad Request (400):
Body: (Only text files (.txt) are supported.)
Description: Indicates that there was a bad request,in cases of invalid file format.










# Error Handling 







# H2 Database
# 
