<!DOCTYPE html>
<!--[if IE 8]>         <html class="ie8"> <![endif]-->
<!--[if IE 9]>         <html class="ie9 gt-ie8"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="gt-ie8 gt-ie9 not-ie"> <!--<![endif]-->
<head>
<#include "common/header.ftl" encoding="UTF-8">

</head>

<body class="theme-default main-menu-animated">

<script>var init = [];</script>
<#--<script src="${base.contextPath}/resources/assets/demo/demo.js"></script>-->

<div id="main-wrapper">
<#include "common/navbar.ftl" encoding="UTF-8">
<#include "common/menu.ftl" encoding="UTF-8">

    <div id="content-wrapper">
        <!-- 导航条 -->
        <ul class="breadcrumb breadcrumb-page">
            <div class="breadcrumb-label text-light-gray">You are here:</div>
            <li><a href="#">Home</a></li>
            <li class="active"><a href="#">监控</a></li>
        </ul>

        <div class="row">
            <script>
                var uploads_data;
                init.push(function () {
                    drawLineChart(null, null);
                    var options = {
                        format: "yyyy-mm-dd",
                        autoclose: true,
                        todayBtn: 'linked',
                        language: 'zh-CN'
                    };
                    var datapickerRange = $('#bs-datepicker-range').datepicker(options);

                    $("#searchOrderQty-btn").click(function(){
                        var beginDate = $('#bs-datepicker-range input[name="start"]').val();
                        var endDate = $('#bs-datepicker-range input[name="end"]').val();
                        if(endDate < beginDate){
                            $.growl.error({title:"OPPS!", message: '[开始时间] 必须要小于 [结束时间]'});
                            return false;
                        }
                        drawLineChart(beginDate, endDate);
                    });
                });

                function drawLineChart(startDate, endDate){
                    $("#orderQty-graph").empty();
                    $.ajax({
                        type: "GET",
                        url: "api/monitor/orderQty",
                        data:{startDate:startDate,endDate:endDate},
                        dataType: "json",
                        success: function (data) {
                            uploads_data = data;
                            if(data != null && data.result != null){
                                var resultMap = data.result;
                                uploads_data = resultMap;
                            }
                            Morris.Line({
                                element: 'orderQty-graph',
                                data: uploads_data,
                                xkey: 'dateVal',
                                ykeys: ['orderQty'],
                                labels: ['下单数'],
                                lineColors: ['#fff'],
                                lineWidth: 2,
                                pointSize: 4,
                                gridLineColor: 'rgba(255,255,255,.5)',
                                resize: true,
                                gridTextColor: '#fff',
                                xLabels: "day",
                                gridTextSize:"12",
                                xLabelFormat: function(d) {
                                    return d.getFullYear() + '-' + (d.getMonth()+1) + '-' + d.getDate();
                                },
                            });
                        }
                    });
                }

            </script>

            <div class="panel">
                <div class="panel-heading">
                    <span class="panel-title">订单下单量统计</span>
                </div>
                <div class="panel">
                    <div class="panel-body">
                        <!-- Range -->
                        <h6 class="text-muted text-semibold text-xs" style="margin:10px 0 10px 0;">RANGE</h6>

                        <div class="input-daterange input-group" id="bs-datepicker-range" style="  right: 220px;left: 20px;max-width: 800px;">
                            <input type="text" class="input-sm form-control" name="start" placeholder="开始日期">
                            <span class="input-group-addon">to</span>
                            <input type="text" class="input-sm form-control" name="end" placeholder="结束日期">
                        </div>
                        <button id="searchOrderQty-btn" style="max-width: 800px;position:relative;left: 20px;margin-top: 10px;" class="btn btn-labeled btn-block">
                            查询
                        </button>
                    </div>
                </div>
                <div class="panel-body">
                    <div id="orderQty-graph" class="graph" style="background-color: #1D89CF;position: relative">

                    </div>
                </div>
            </div>
        </div>

        <!-- Page wide horizontal line -->
        <hr class="no-grid-gutter-h grid-gutter-margin-b no-margin-t">

    </div>
    <!-- / #content-wrapper -->
    <div id="main-menu-bg"></div>
</div>
<!-- / #main-wrapper -->
<#include "common/js.ftl" encoding="UTF-8">

</body>
</html>