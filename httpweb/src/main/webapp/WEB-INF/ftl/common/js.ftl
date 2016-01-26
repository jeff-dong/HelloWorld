<!-- Get jQuery from Google CDN -->
<!--[if !IE]> -->
<script type="text/javascript"> window.jQuery || document.write('<script src="${base.contextPath}/resources/js/jquery.min.js">'+"<"+"/script>"); </script>
<!-- <![endif]-->
<!--[if lte IE 9]>
<script type="text/javascript"> window.jQuery || document.write('<script src="${base.contextPath}/resources/js/jquery.min.js">'+"<"+"/script>"); </script>
<![endif]-->


<!-- Pixel Admin's javascripts -->
<script src="${base.contextPath}/resources/assets/javascripts/bootstrap.min.js"></script>
<script src="${base.contextPath}/resources/assets/javascripts/pixel-admin.min.js"></script>

<script type="text/javascript">
    var datatable;
    //1-未使用; 2-退款中; 3-已退款; 4-已使用;5-已过期；6-待退款中
    function getCouponStatusName(statusId){
        var statusDiv = "未知";
        if(statusId != null){
            switch(statusId){
                case 1:
                    statusDiv = "未使用";break;
                case 2:
                    statusDiv = "退款中";break;
                case 3:
                    statusDiv = "已退款";break;
                case 4:
                    statusDiv = "已使用";break;
                case 5:
                    statusDiv = "已过期";break;
                case 6:
                    statusDiv = "待退款中";break;
            }
        }
        return statusDiv;
    }

    function getProcessStatusName(statusId){
        var statusDiv = "未知";
        if(statusId != null){
            switch(statusId){
                case 0:
                    statusDiv = "处理完成";break;
                case 1:
                    statusDiv = "处理中";break;
            }
        }
        return statusDiv;
    }

    //1-未使用; 2-退款中; 3-已退款; 4-已使用;5-已过期；6-待退款中
    function getOrderStatusName(statusId){
        var statusName = "未知";
        switch (statusId) {
            case 1:
                statusName = "待下单";
                break;
            case 2:
                statusName = "待支付";
                break;
            case 3:
                statusName = "支付中";
                break;
            case 4:
                statusName = "待出劵";
                break;
            case 5:
                statusName = "已出劵";
                break;
            case 6:
                statusName = "出劵失败";
                break;
            case 7:
                statusName = "下单失败";
                break;
            case 8:
                statusName = "支付失败";
                break;
            case 9:
                statusName = "订单已退款";
                break;
            case 10:
                statusName = "下单中";
                break;
            case 11:
                statusName = "出券中";
                break;
            case 12:
                statusName = "同步券状态中";
                break;
        }
        return statusName;
    }

    function dropdownForProcessStatus(id,orderId, className, defaultValue){
        var idStr = (id!=null)?" id = '"+id+"' ":"";
        var classStr = (className!=null)?" className = '"+className+"' ":"";
        var dropdownContent = "<select "+idStr+" orderId='"+orderId+"' class='form-control form-group-margin' "+classStr+" >" +
                            "<option value='0' "+(defaultValue == "0"?"selected":"")+">处理完成</option>" +
                            "<option value='1' "+(defaultValue == "1"?"selected":"")+">处理中</option>";
        return dropdownContent + "</select>";
    }

    function toggleBtnClass(){

    }

    function clearSelect2(select2Id){
        $("#"+select2Id+"").val(null).trigger("change");
    }

    init.push(function () {

    });
    window.PixelAdmin.start(init);
</script>
