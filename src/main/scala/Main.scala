package xyz.hyperreal.express_test

import io.scalajs.nodejs.http.{Http, RequestOptions, ServerResponse}
import io.scalajs.nodejs._
import io.scalajs.npm.express._
import scala.concurrent.duration._


object Main extends App {

  // create the Express application instance
  val app = Express()

  // define a port
  val port = 8080

  // setup the server with routes
  val server = app
    .get("/", (_: Request, res: Response) => res.send("Hello GET"))
    .post("/", (_: Request, res: Response) => res.send("Hello POST"))
    .delete("/:id", (req: Request, res: Response) => res.send(s"Hello DELETE - ${req.params.get("id").orNull}"))
    .get("/:id", (req: Request, res: Response) => res.send(s"Hello GET - ${req.params.get("id").orNull}"))
    .get("/list_user", (_: Request, res: Response) => res.send("Page Listing"))
    .get("/ab*de", (_: Request, res: Response) => res.send("Page Pattern Match"))
    .listen(port)

}