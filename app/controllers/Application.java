package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    public static void  register() {
        render();
    }
    public static void  menu() {
        render();
    }

    public static void listTeams(){

        List<Team> teams = Team.findAll();
        render(teams);
    }

    public static void calendar(){
        List<Match> matches = Match.findAll();
        render(matches);
    }

    public static void registerUser(String n, String e, String t, String p) {

        User u = User.find("byNameAndPassword", n, p).first();
        if (u == null) {
            new User(n, e, t, p).save();
            renderText("User registered");
        }
        else
        {
            renderText("User already exists");
        }
    }

    public static void loginUser(String n, String p) {
        User u = User.find("byNameAndPassword", n, p).first();
        if (u == null) {
            renderTemplate("Application/index.html");
            renderText("User not found");
        }
        else
        {
            renderTemplate("Application/menu.html");
            //renderArgs.put("user", u);
            //List<Match> matches = Match.findAll();
            //renderArgs.put("matches", matches);
            //renderTemplate("Application/PaginaPrincipal.html");
            //renderText("User found");

        }
    }

    public static void deleteUser(String n, String p) {
        User u = User.find("byNameAndPassword", n, p).first();
        if (u != null) {
            u.delete();
            renderText("User deleted");
        }
        else
        {
            renderText("User not found");
        }

    }

    public static void buyTicket(String n, String m, int nt, float p) {

        User u = User.find("byName", n).first();
        Match ma = Match.find("byCity", m).first();
        if (u != null && ma != null) {
            Ticket t = new Ticket(nt, p);
            t.save();
            //t.users.add(u);
            u.tickets.add(t); u.save();
            ma.ticket = t; ma.save();


            renderText("Ticket bought");
        }
        else
        {
            renderText("User or match not found");
        }


    }




    public static void iniDB() {


        User u1 = new User("Vicenç", "vicenç@pes.com", "666666666", "vicenç");  u1.save();
        User u2 = new User("Hugo", "hugo@pes.com", "346463", "hugo");   u2.save();
        User u3 = new User("Leo", "leo@pes.com", "34989898", "leo");      u3.save();


        Match m1 = new Match("Barcelona", "2014-10-25");m1.save();
        Match m2 = new Match("Barcelona", "2014-11-01");m2.save();



        Team t1 = new Team("Barcelona", "Camp Nou"); t1.save();
        t1.matches.add(m1);
        t1.matches.add(m2); t1.save();

        Team t2 = new Team("Real Madrid", "Santiago Bernabeu"); t2.save();
        t2.matches.add(m1); t2.save();



        Team t3 = new Team("Atletico Madrid", "Vicente Calderon"); t3.save();
        t3.matches.add(m2); t3.save();

        m1.teams.add(t1); m1.teams.add(t2); m1.save();
        m2.teams.add(t1); m2.teams.add(t3); m2.save();

        Team t4 = new Team("Valencia", "Mestalla");
        Team t5 = new Team("Sevilla", "Sanchez Pizjuan");
        Team t6 = new Team("Malaga", "La Rosaleda");
        Team t7 = new Team("Athletic Bilbao", "San Mames");
        Team t8 = new Team("Real Sociedad", "Anoeta");
        Team t9 = new Team("Villarreal", "El Madrigal");
        Team t10 = new Team("Espanyol", "Cornella-El Prat");
        Team t11 = new Team("Getafe", "Coliseum Alfonso Perez");
        Team t12 = new Team("Levante", "Ciutat de Valencia");
        Team t13 = new Team("Rayo Vallecano", "Vallecas");
        Team t14 = new Team("Celta Vigo", "Balaidos");
        Team t15 = new Team("Granada", "Nuevo Los Carmenes");
        Team t16 = new Team("Elche", "Martinez Valero");
        Team t17 = new Team("Almeria", "Juegos Mediterraneos");
        Team t18 = new Team("Osasuna", "El Sadar");
        Team t19 = new Team("Valladolid", "Jose Zorrilla");
        Team t20 = new Team("Real Betis", "Benito Villamarin");



        t4.save();
        t5.save();
        t6.save();
        t7.save();
        t8.save();
        t9.save();
        t10.save();
        t11.save();
        t12.save();
        t13.save();
        t14.save();
        t15.save();
        t16.save();
        t17.save();
        t18.save();
        t19.save();
        t20.save();
        renderText("Data base loaded");








    }

    public static void RegisterTeam(String n, String ns) {

        Team t = Team.find("byName", n).first();
        if (t == null) {
            new Team(n, ns).save();
            renderText("Team registered");
        }
        else
        {
            renderText("Team already exists");
        }
    }

    public static void deleteTeam(String n) {
        Team t = Team.find("byName", n).first();
        if (t != null) {
            t.delete();
            renderText("Team deleted");
        }
        else
        {
            renderText("Team not found");
        }

    }




}