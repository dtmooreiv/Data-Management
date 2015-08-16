var people;

function addPersonListItems () {
    var persons = JSON.parse(this.responseText);
    _.forEach(persons, function(person, index) {
        $('#persons').append("<p>" + person.name + "</p>");
    });

    people = persons;
}

var personsRequest = new XMLHttpRequest();
personsRequest.onload = addPersonListItems;
personsRequest.open("get", "/persons", true);
personsRequest.send();

