package controllers


import models.{AccountDB, Account, DB, Person}
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._
import sorm.persisted.Persisted

class Application extends Controller {
  trait Persisted

  def index = Action {
    Ok(views.html.index("Your new application is ready!!"))
  }

  val personForm: Form[Person] = Form {
    mapping (
      "name" -> text,
      "dob" -> jodaDate,
      "address" -> text
    )(Person.apply)(Person.unapply)
  }

  val accountForm: Form[Account] = Form {
    mapping (
      "username" -> text,
      "password" -> text(minLength = 10)
    ) (Account.apply)(Account.unapply)
  }

  def addPerson = Action { implicit request =>
    val person = personForm.bindFromRequest.get
    DB.save(person)
    Redirect(routes.Application.index())
  }

  def getPersons = Action {
    val persons = DB.query[Person].fetch()
    Ok(Json.toJson(persons))
  }
}
