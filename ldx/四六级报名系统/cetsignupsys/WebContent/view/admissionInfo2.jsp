
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>How transform HTML into PDF</title>
        <link rel="stylesheet" href="../css/style.css">
        
    </head>
    <body>
        
        <div class="tools">
            <button id="btn-html2canvas">export PDF by using jspdf + html2canvas</button>
        </div>

        <div class="container">

            <div id="content">
            
                <div class="content-banner">
                    <img class="content-banner-logo" src="${CANDIDATEINFO.personImg }" alt="logo">
                    <h2>How Transform HTML Into PDF</h2>
                </div>
                <div class="content-main">
                


                    <h3>准考证号：${CANDIDATEINFO.id }</h3>
                    <h3>姓名：${CANDIDATEINFO.personImg }</h3>
                    <h3>性别：${CANDIDATEINFO.personImg }</h3>
                    <h3>身份证号：${CANDIDATEINFO.personImg }</h3>
                    <h3>考试类型：${CANDIDATEINFO.personImg }</h3>
                   

                </div>

            </div>

        </div>


        <script src="../js/jspdf.debug.js"></script>
        <script src="../js/html2canvas.js"></script>
        <script src="../main.js"></script>

    </body>

</html>