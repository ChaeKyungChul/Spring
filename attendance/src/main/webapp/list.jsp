<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/script.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <form action="#">
        <div class="container-list">
            <h3 class="text-center mb-5">시간표</h3>
            <table class="table list-tb">
                <colgroup>
                   <col width="15%">
                   <col width="10%">
                   <col width="10%">
                   <col width="10%">
                   <col width="10%">
                   <col width="10%">
                </colgroup>
                <thead class="text-center">
                    <tr>
                        <th>시간/요일</th>
                        <th>월</th>
                        <th>화</th>
                        <th>수</th>
                        <th>목</th>
                        <th>금</th>
                    </tr>
                </thead>
                <tbody class="text-center">
                   <!-- loop --> 
                   <tr>
                       <td>9:00</td>
                       <td class="java">JAVA</td>
                       <td></td>
                       <td class="java">JAVA</td>
                       <td></td>
                       <td></td>
                   </tr>
                   <tr>
                    <td>10:00</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>11:00</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>12:00</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>13:00</td>
                    <td></td>
                    <td class="mysql">MYSQL</td>
                    <td></td>
                    <td class="mysql">MYSQL</td>
                    <td></td>
                </tr>
                <tr>
                    <td>14:00</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>15:00</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>16:00</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td class="python">PYTHON</td>
                </tr>
                <tr>
                    <td>17:00</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>18:00</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                   <!-- /loop -->
                </tbody>
            </table>
    </div>
    </form>
</body>
</html>