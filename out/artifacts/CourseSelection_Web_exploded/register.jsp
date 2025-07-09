<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp"%>

<div class="container-fluid page-body-wrapper full-page-wrapper">
    <div class="content-wrapper d-flex align-items-stretch auth auth-img-bg">
        <div class="row flex-grow">
            <div class="col-lg-6 d-flex align-items-center justify-content-center">
                <div class="auth-form-transparent text-left p-3">
                    <div class="brand-logo">
                        <img src="/images/logo.svg" alt="logo">
                    </div>
                    <h4>New here?</h4>
                    <h6 class="font-weight-light">Join us today! It takes only few steps</h6>
                    <form class="pt-3" role="form" action="/RegisterServlet" method="post">
                        <div class="form-group">
                            <label>用户名</label>
                            <div class="input-group">
                                <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-account-outline text-primary"></i>
                      </span>
                                </div>
                                <input type="text" class="form-control form-control-lg border-left-0"
                                       placeholder="Username" value="${param.username}" name="username" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>学号/工号</label>
                            <div class="input-group">
                                <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-email-outline text-primary"></i>
                      </span>
                                </div>
                                <input type="text" class="form-control form-control-lg border-left-0"
                                       placeholder="StudentID/TeacherID" value="${param.otherId}" name="userId" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label>身份</label>
                            <select class="form-control form-control-lg" name="userType" id="exampleFormControlSelect2" required="required">
                                <option value="student">学生</option>
                                <option value="teacher">老师</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <div class="input-group">
                                <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-lock-outline text-primary"></i>
                      </span>
                                </div>
                                <input type="password" class="form-control form-control-lg border-left-0"
                                       id="exampleInputPassword" value="${param.password}" name="password" placeholder="Password" required="required">
                            </div>
                        </div>
                        <div class="mb-4">
                            <div class="form-check">
                                <label class="form-check-label text-muted">
                                    <input type="checkbox" class="form-check-input" required="required">
                                    I agree to all Terms & Conditions
                                </label>
                            </div>
                        </div>
                        <h5 class="text-secondary">${registerMsg}</h5>
                        <div class="mt-3">
                            <input type="submit" value="SIGN UP" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">
                        </div>
                        <div class="text-center mt-4 font-weight-light">
                            Already have an account? <a href="login.jsp" class="text-primary">Login</a>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-lg-6 register-half-bg d-flex flex-row">
                <p class="text-white font-weight-medium text-center flex-grow align-self-end">Copyright &copy; 2018  All rights reserved.</p>
            </div>
        </div>
<%@ include file="footer.jsp"%>