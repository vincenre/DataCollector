# REST API Markdown

##### URL : http://localhost:8080/

### 1. URL/patientInfo

Returns json data of all the patients for which data is available

* Method : `GET`

* URL Params : `NONE`

* Data Params : `NONE`

* Success Response:
  * Code : `200`
    Content : `[
                  {
                      "patientId": 14,
                      "appointmentId": 1984,
                      "gender": "male",
                      "neighborHood": "Sharonville",
                      "age": 42
                  }
              ]`
              
* Sample Call:
  * `localhost:8080/patientInfo`
  
### 2. URL/patientInfo/{id}

Returns json of patient Info based on the ID.

* Method : `GET`

* URL Params : `id`

* Data Params : `NONE`

* Success Response:
  * Code : `200`
  * Content : `{
                  "patientId": 29900000000000,
                  "appointmentId": 5642903,
                  "gender": "female",
                  "neighborHood": "JARDIM DA PENHA",
                  "age": 62
              }`
  
* Sample Call:
  * `http://localhost:8080/patientInfo/1`
  
### 3. URL/patientInfo/gender/{gender}

Returns the list of patients that belong to the Gender.

* Method : `GET`

* URL Params : `gender`

* Data Params : `NONE`

* Success Response:
  * Code : `200`
  * Content : `[
                  {
                      "patientId": 559000000000000,
                      "appointmentId": 5642503,
                      "gender": "male",
                      "neighborHood": "JARDIM DA PENHA",
                      "age": 56
                  },
                  {
                      "patientId": 7540000000000,
                      "appointmentId": 5620163,
                      "gender": "male",
                      "neighborHood": "NOVA PALESTINA",
                      "age": 29
                  },
                  {
                      "patientId": 911000000000000,
                      "appointmentId": 5636249,
                      "gender": "male",
                      "neighborHood": "NOVA PALESTINA",
                      "age": 28
                  },
                  {
                      "patientId": 84600000000000,
                      "appointmentId": 5633121,
                      "gender": "male",
                      "neighborHood": "NOVA PALESTINA",
                      "age": 50
                  }
              ]`
  
* Sample Call:
  * `http://localhost:8080/patientInfo/gender/male`
  
### 4. URL/patientInfo/neighborhood/{neighborhood}

Returns the list of patients that belong to the same Neighborhood.

* Method : `GET`

* URL Params : `neighborhood`

* Data Params : `NONE`

* Success Response:
  * Code : `200`
  * Content : `[
                  {
                      "patientId": 29900000000000,
                      "appointmentId": 5642903,
                      "gender": "female",
                      "neighborHood": "JARDIM DA PENHA",
                      "age": 62
                  },
                  {
                      "patientId": 559000000000000,
                      "appointmentId": 5642503,
                      "gender": "male",
                      "neighborHood": "JARDIM DA PENHA",
                      "age": 56
                  },
                  {
                      "patientId": 8840000000000,
                      "appointmentId": 5642494,
                      "gender": "female",
                      "neighborHood": "JARDIM DA PENHA",
                      "age": 56
                  }
              ]`
  
* Sample Call:
  * `http://localhost:8080/patientInfo/neighborhood/JARDIM+DA+PENHA`
