
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@include file="navbar.jsp"%>
<%@include file="sidebar.jsp"%>

<!-- partial -->
<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">
            <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">个人信息</h4>
                        <p class="card-description">
                            这里是你的个人信息
                        </p>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>类别</th>
                                    <th>信息</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>用户ID</td>
                                    <td>${user.userId}</td>
                                </tr>
                                <tr>
                                    <td>用户名</td>
                                    <td>${user.username}</td>
                                </tr>
                                <tr>
                                    <td>姓名</td>
                                    <td>${user.name}</td>
                                </tr>
                                <tr>
                                    <td>身份</td>
                                    <td>${user.userType}</td>
                                </tr>
                                <tr>
                                    <td>学号/工号</td>
                                    <td>${user.otherNo}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">更改密码</h4>
                        <p class="card-description">
                            在这里更改你的密码
                        </p>
                        <form class="forms-sample" action="/UserServlet?action=update" method="post">
                            <div class="form-group row">
                                <label for="Password" class="col-sm-3 col-form-label">新的密码</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="Password" placeholder="New Password" name="Password" required="required">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="Re Password" class="col-sm-3 col-form-label">确认你的新密码</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="Re Password" placeholder="Re Password" name="rePassword" required="required">
                                </div>
                            </div>
                            <div class="form-check form-check-flat form-check-primary">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input" required="required">
                                    确认更改密码
                                </label>
                            </div>
                            <h5 class="text-secondary">${msg}</h5>
                            <button type="submit" class="btn btn-primary mr-2">提交</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
        </div>
    </div>
    <!-- content-wrapper ends -->
    <!-- partial:partials/_footer.html -->
    <footer class="footer">
        <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © <a target="_blank" href="http://www.mobanwang.com/" title="网页模板">网页模板</a>. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="mdi mdi-heart text-danger"></i></span>
        </div>
    </footer>
    <!-- partial -->

    <%@include file="footer.jsp"%>
