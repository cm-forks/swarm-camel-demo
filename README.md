



curl -X GET http://localhost:8080/jmx
curl -d "{\"type\":\"read\",\"mbean\":\"java.lang:type=Memory\",\"attribute\":\"HeapMemoryUsage\",\"path\":\"used\"}" http://localhost:8080/jmx/ && echo ""
