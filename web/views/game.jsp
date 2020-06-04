<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 28.05.2020
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Super game!</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Веб-приложение</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Игра "бык-корова"</h2>
        </div>
        <%
            List<String> uv = (List<String>) request.getAttribute("userValues");
            List<String> ur = (List<String>) request.getAttribute("userResults");
            if (uv != null && !uv.isEmpty()) {
                Iterator<String> userValues = uv.iterator();
                Iterator<String> userResults = ur.iterator();
                out.println("<ul class=\"w3-ul\" id=\"navigation\">");
                while (userValues.hasNext()) {
                    out.println("<li class=\"w3-hover-sand\" >" + userValues.next() + " -- " + userResults.next() + "</li>");
                }
                out.println("</ul>");
            } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                    +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                    "   <h5>Вы еще не начинали играть!</h5>\n" +
                    "</div>");
        %>
    </div>
</div>

<div class="w3-container w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Введите четырехзначное число!
                <form method="POST" ACTION="/Game" class="w3-selection w3-light-grey w3-padding">
                    <select name="n1">
                        <option>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                    </select>
                    <select name="n2">
                        <option>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                    </select>
                    <select name="n3">
                        <option>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                    </select>
                    <select name="n4">
                        <option>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                    </select>
                    <button type="Ввод" class="w3-btn w3-green w3-round-large w3-margin-bottom">Ввод</button>
                </form>
            </h2>
        </div>
    </div>
</div>
<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <a class="w3-btn w3-round-large" href="/">Вернуться на главную</a>
</div>
</body>
</html>
