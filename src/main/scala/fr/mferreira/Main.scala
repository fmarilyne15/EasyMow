package fr.mferreira


import fr.mferreira.model.Print
import fr.mferreira.parser.Parser

import scala.util.{Failure, Success}


object Main extends App{
    Parser.getLinesFromFile("\\test1.txt") match {
        case Success(lines) =>
            Parser.lineToLawn(lines.head) match {
                case Success(lawn) =>
                    Parser.parseMowersWithCommands(lines.drop(1)) match {
                        case Left(mowersWithCommands) => lawn.simulate(mowersWithCommands).foreach(x => println(Print.print(x)))
                        case Right(_) => println("problème pour parser la première tondeuse ou la première ligne de commandes ")
                    }
                case Failure(_) => println("problème pour parser le terrain")
            }
        case Failure(_) => println("problème pour ouvrir le fichier")
    }

}