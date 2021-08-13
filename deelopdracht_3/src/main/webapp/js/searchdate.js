let searchDayPersonRequest = new XMLHttpRequest();

function searchPersons(){
    let Datetext = document.getElementById("Date").value;
    let information =
        "&date=" + encodeURIComponent(Datetext) +
        "&command=searchdate";

    searchDayPersonRequest.open("POST", "/Controller");
    searchDayPersonRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded' );
    searchDayPersonRequest.onreadystatechange = showPersons;
    searchDayPersonRequest.send(information)
}

function showPersons(){
    if (searchDayPersonRequest.readyState === 4) {
        if (searchDayPersonRequest.status === 200) {
            let persons = JSON.parse(searchDayPersonRequest.responseText);
            document.getElementById("tbody").innerHTML = "";
            for (let i = 0; i < persons.length; i++) {
                let a = "<tr>" +
                    "<td>" + persons[i]["firstName"] + "</td>" +
                    "<td>" + persons[i]["lastname"] + "</td>" +
                    "<td>" + persons[i]["date"] + "</td>" +
                    "<td>" + persons[i]["room"] + "</td>" +
                    "<td>" + persons[i]["email"] + "</td>" +
                    "<td>" + persons[i]["gsm"] + "</td>" +
                    "</tr>";
                document.getElementById("tbody").innerHTML += a;
            }
        }
    }
}
