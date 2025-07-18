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
                    <h4>Welcome back!</h4>
                    <h6 class="font-weight-light">Happy to see you again!</h6>
                    <form class="pt-3" role="form" action="/LoginServlet" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail">Username</label>
                            <div class="input-group">
                                <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-account-outline text-primary"></i>
                      </span>
                                </div>
                                <input type="text" class="form-control form-control-lg border-left-0"
                                       value="${param.username}" id="exampleInputEmail" placeholder="Username/StudentId/TeacherId" name="username" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword">Password</label>
                            <div class="input-group">
                                <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-lock-outline text-primary"></i>
                      </span>
                                </div>
                                <input type="password" class="form-control form-control-lg border-left-0"
                                       value="${param.password}" id="exampleInputPassword" placeholder="Password" name="password" required="required">
                            </div>
                        </div>
                        <div class="my-2 d-flex justify-content-between align-items-center">
                            <div class="form-check">
                                <label class="form-check-label text-muted">
                                    ${loginMsg}
                                </label>
                            </div>
                            <a href="forgotPassword.jsp" class="auth-link text-black">Forgot password?</a>
                        </div>
                        <div class="my-3">
                            <input type="submit" value="LOGIN" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">
                        </div>
                        <div class="text-center mt-4 font-weight-light">
                            Don't have an account? <a href="register.jsp" class="text-primary">Create</a>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-lg-6 login-half-bg d-flex flex-row">
                <p class="text-white font-weight-medium text-center flex-grow align-self-end">Copyright &copy; 2018  All rights reserved.</p>
            </div>
        </div>

<%@ include file="footer.jsp"%>