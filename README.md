# TABLE

Unreasonable surgery to follow board


{
“surgeon”: “Dr. Hamburglar”,
"name": "Bobert, Bob",
“dateOfBirth”: “6/8/76”
“isInpatient”: true,
“diagnosis”: “ingrown toenail right first toe”,
“procedure”: “RIGHT BELOW KNEE AMPUTATION”,
“minutes”: 90,
"comments" : [
"latex allergy", 
“requests that thing he likes for positioning”
]
“drAvailability”: “after 1800”;
“toFollowBoardNum”: 1
},

{
“surgeon”: “Dr. Etrange”,
"name": "Case, Justin",
“dateOfBirth”: “10/5/99”
“isInpatient”: false,
“diagnosis”: “right distal humerus fracture”,
“procedure”: “LAPAROSCOPIC APPENDECTOMY POSSIBLE OPEN”,
“minutes”: 75,
"comments" : [
"lithotomy", 
“To follow self”, 
“PA”
]
“drAvailability”: “now”;
“toFollowBoardNum”: 2
},


{
“surgeon”: “Dr. BradPitt”,
"name": "Shmenry, Henry",
“dateOfBirth”: “2/13/45”
“isInpatient”: true,
“diagnosis”: “swallowed a clown toy”,
“procedure”: “CLOWNECTOMY”,
“minutes”: 100,
"comments" : [
"PA", 
“supine”
]
“drAvailability”: “1400-2000”;
“toFollowBoardNum”: 3
},

{
“surgeon”: “Dr. BradPitt”,
"name": "Ryan, Rusty",
“dateOfBirth”: "3/20/75"
“isInpatient”: true,
“diagnosis”: “cholecystitis”,
“procedure”: “HARDWARE REMOVAL MANDIBLE”,
“minutes”: 80,
"comments" : [
"dental tray", 
"ex fix removal"
]
“drAvailability”: “1400-2000”;
“toFollowBoardNum”: 4
},


{
“surgeon”: “Dr. Oz”,
"name": "Dr. Phil",
“dateOfBirth”: “9/1/50”
“isInpatient”: true,
“diagnosis”: “ear ache”,
“procedure”: “INSERTION OF COCHLEAR IMPLANT”,
“minutes”: 120,
"comments" : [
"I’m Dr. Oz I should be first", 
“page my assistant”, 
“swivel chair”,
“Resident Assisting”
]
“drAvailability”: “after my show”;
“toFollowBoardNum”: 5
}


2. Create a GET endpoint that will allow users to retrieve all surgeries
	a. endpoint: /surgery
	b. response code: 200 (OK)
	c. response body: a JSON array of all pets
3. Create a GET endpoint that will allow users to retrieve an surgical case by id
	a. endpoint: /surgery/{id}
   	b. if found:
		i. response code: 200 (OK)
		ii. response body: a JSON object of pet
   	c. if not found:
		i. response code: 404 (Not Found)
		ii. response body: "Surgical encounter not found"
4. Create a POST endpoint that will allow users to create a new surgical case
	a. endpoint: /surgery/{id}
	b. response code: 201 (Created)
	c. response body: JSON object of created surgical case (with ID)
5. Create a PUT endpoint that will allow users to update an existing surgical case description by ID
	a. /surgery/{id}
	b. response code: 200 (OK)
	c. newly update JSON object with ID
6. Create a PATCH endpoint that will allow users to update an existing surgical case description by ID
	a. /surgery/{id}
	b. response code: 200 (OK)
	c. newly update JSON object with ID
7. Create a DELETE endpoint that will allow users to delete an existing surgical case by ID
	a. /surgery/{id}
	b. response code: 204 (No Content)
	c. response body: empty
8. 
