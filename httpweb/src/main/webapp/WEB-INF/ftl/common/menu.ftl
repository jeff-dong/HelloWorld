<div id="main-menu" role="navigation">
    <div id="main-menu-inner">
        <div class="menu-content top" id="menu-content-demo">
            <!-- Menu custom content demo
                     CSS:        styles/pixel-admin-less/demo.less or styles/pixel-admin-scss/_demo.scss
                     Javascript: html/${base.contextPath}/resources/assets/demo/demo.js
                 -->
            <div>
                <div class="text-bg" style="font-size: 13px;"><span class="text-slim">欢迎,</span> <span class="text-semibold">${CtripAccount.displayName}</span></div>

                <img src="${base.contextPath}/resources/assets/demo/avatars/1.jpg" alt="" class="">
                <div class="btn-group">
                    <a href="#" class="btn btn-xs btn-primary btn-outline dark"><i class="fa fa-envelope"></i></a>
                    <a href="#" class="btn btn-xs btn-primary btn-outline dark"><i class="fa fa-user"></i></a>
                    <a href="#" class="btn btn-xs btn-primary btn-outline dark"><i class="fa fa-cog"></i></a>
                    <a href="#" class="btn btn-xs btn-danger btn-outline dark"><i class="fa fa-power-off"></i></a>
                </div>
                <a href="#" class="close">&times;</a>
            </div>
        </div>
        <ul class="navigation">
            <li>
                <a href="monitor"><i class="menu-icon fa fa-dashboard"></i><span class="mm-text">监控</span></a>
            </li>
            <li class="mm-dropdown">
                <a href="order"><i class="menu-icon fa fa-shopping-cart"></i><span class="mm-text">订单管理</span></a>
            </li>
            <li class="mm-dropdown">
                <a href="coupon"><i class="menu-icon fa fa-ticket"></i><span class="mm-text">团购券管理</span></a>
            </li>
            <li class="mm-dropdown">
                <a href="#"><i class="menu-icon fa fa-user"></i><span class="mm-text">第三方账户管理</span></a>
                <ul class="mmc-dropdown-delay animated fadeInLeft">
                    <li>
                        <a tabindex="-1" href="vendorAccount"><span class="mm-text">下单账号管理</span></a>
                    </li>
                    <li>
                        <a tabindex="-1" href="payAccount"><span class="mm-text">支付账号管理</span></a>
                    </li>
                </ul>
            </li>
            <li class="mm-dropdown">
                <a href="refund"><i class="menu-icon fa fa-th"></i><span class="mm-text">退券管理</span></a>
            </li>
            <li class="mm-dropdown">
                <a href="payment"><i class="menu-icon fa fa-credit-card"></i><span class="mm-text">支付记录</span></a>
            </li>
            <li class="mm-dropdown">
                <a href="#"><i class="menu-icon fa fa-building-o"></i><span class="mm-text">供应商城市配置</span></a>
                <ul class="mmc-dropdown-delay animated fadeInLeft">
                    <li>
                        <a href="vendorCity"><i class="menu-icon fa fa-building-o"></i><span class="mm-text">供应商城市配置</span></a>
                    </li>
                    <li>
                        <a href="vendor"><i class="menu-icon fa fa-building-o"></i><span class="mm-text">供应商配置</span></a>
                    </li>
                </ul>
            </li>
            <li class="mm-dropdown">
                <a href="operationLog"><i class="menu-icon fa  fa-file-text"></i><span class="mm-text">订单操作日志</span></a>
            </li>
            <li class="mm-dropdown">
                <a href="configure"><i class="menu-icon fa fa-gear"></i><span class="mm-text">Key-Value 配置</span></a>
            </li>
        </ul> <!-- / .navigation -->
    </div> <!-- / #main-menu-inner -->
</div> <!-- / #main-menu -->