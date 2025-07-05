<%--
  Created by IntelliJ IDEA.
  User: 星痕
  Date: 2025/7/5
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- partial -->
<div class="container-fluid page-body-wrapper">
    <!-- partial:partials/_sidebar.html -->
    <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
            <li class="nav-item ${pageContext.request.requestURI.endsWith('index.jsp') ? 'active' : ''}">
                <a class="nav-link" href="index.jsp">
                    <i class="mdi mdi-home menu-icon"></i>
                    <span class="menu-title">首页</span>
                </a>
            </li>
            <!-- 学生菜单 - 仅当用户类型为student时显示 -->
            <c:if test="${sessionScope.userType == 'student'}">
                <li class="nav-item ${pageContext.request.requestURI.contains('student') ? 'active' : ''}">
                    <a class="nav-link" data-toggle="collapse" href="#student-menu"
                       aria-expanded="${pageContext.request.requestURI.contains('student')}"
                       aria-controls="student-menu">
                        <i class="mdi mdi-circle-outline menu-icon"></i>
                        <span class="menu-title">学生课程管理</span>
                        <i class="menu-arrow"></i>
                    </a>
                    <div class="collapse ${pageContext.request.requestURI.contains('student') ? 'show' : ''}" id="student-menu">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item ${pageContext.request.requestURI.endsWith('selectCourse.jsp') ? 'active' : ''}">
                                <a class="nav-link" href="pages/student/selectCourse.jsp">选课</a>
                            </li>
                            <li class="nav-item ${pageContext.request.requestURI.endsWith('courseSchedule.jsp') ? 'active' : ''}">
                                <a class="nav-link" href="pages/student/courseSchedule.jsp">我的课表</a>
                            </li>
                            <li class="nav-item ${pageContext.request.requestURI.endsWith('exams.jsp') ? 'active' : ''}">
                                <a class="nav-link" href="pages/student/exams.jsp">我的考试</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </c:if>

            <!-- 教师菜单 - 仅当用户类型为teacher时显示 -->
            <c:if test="${sessionScope.userType == 'teacher'}">
                <li class="nav-item ${pageContext.request.requestURI.contains('teacher') ? 'active' : ''}">
                    <a class="nav-link" data-toggle="collapse" href="#teacher-menu"
                       aria-expanded="${pageContext.request.requestURI.contains('teacher')}"
                       aria-controls="teacher-menu">
                        <i class="mdi mdi-circle-outline menu-icon"></i>
                        <span class="menu-title">教师课程管理</span>
                        <i class="menu-arrow"></i>
                    </a>
                    <div class="collapse ${pageContext.request.requestURI.contains('teacher') ? 'show' : ''}" id="teacher-menu">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item ${pageContext.request.requestURI.endsWith('myCourses.jsp') ? 'active' : ''}">
                                <a class="nav-link" href="pages/teacher/myCourses.jsp">我的课程</a>
                            </li>
                            <li class="nav-item ${pageContext.request.requestURI.endsWith('courseSettings.jsp') ? 'active' : ''}">
                                <a class="nav-link" href="pages/teacher/courseSettings.jsp">课程设置</a>
                            </li>
                            <li class="nav-item ${pageContext.request.requestURI.endsWith('scheduleAdjustment.jsp') ? 'active' : ''}">
                                <a class="nav-link" href="pages/teacher/scheduleAdjustment.jsp">课表调整</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </c:if>

            <li class="nav-item ${pageContext.request.requestURI.contains('forms') ? 'active' : ''}">
                <a class="nav-link" href="pages/forms/basic_elements.html">
                    <i class="mdi mdi-view-headline menu-icon"></i>
                    <span class="menu-title">Form elements</span>
                </a>
            </li>

            <li class="nav-item ${pageContext.request.requestURI.contains('charts') ? 'active' : ''}">
                <a class="nav-link" href="pages/charts/chartjs.html">
                    <i class="mdi mdi-chart-pie menu-icon"></i>
                    <span class="menu-title">Charts</span>
                </a>
            </li>

            <li class="nav-item ${pageContext.request.requestURI.contains('tables') ? 'active' : ''}">
                <a class="nav-link" href="pages/tables/basic-table.html">
                    <i class="mdi mdi-grid-large menu-icon"></i>
                    <span class="menu-title">Tables</span>
                </a>
            </li>

            <li class="nav-item ${pageContext.request.requestURI.contains('icons') ? 'active' : ''}">
                <a class="nav-link" href="pages/icons/mdi.html">
                    <i class="mdi mdi-emoticon menu-icon"></i>
                    <span class="menu-title">Icons</span>
                </a>
            </li>

            <li class="nav-item ${pageContext.request.requestURI.contains('samples') ? 'active' : ''}">
                <a class="nav-link" data-toggle="collapse" href="#auth"
                   aria-expanded="${pageContext.request.requestURI.contains('samples')}"
                   aria-controls="auth">
                    <i class="mdi mdi-account menu-icon"></i>
                    <span class="menu-title">User Pages</span>
                    <i class="menu-arrow"></i>
                </a>
                <div class="collapse ${pageContext.request.requestURI.contains('samples') ? 'show' : ''}" id="auth">
                    <ul class="nav flex-column sub-menu">
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('login.html') ? 'active' : ''}">
                            <a class="nav-link" href="pages/samples/login.html"> Login </a>
                        </li>
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('login-2.html') ? 'active' : ''}">
                            <a class="nav-link" href="pages/samples/login-2.html"> Login 2 </a>
                        </li>
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('register.html') ? 'active' : ''}">
                            <a class="nav-link" href="pages/samples/register.html"> Register </a>
                        </li>
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('register-2.html') ? 'active' : ''}">
                            <a class="nav-link" href="pages/samples/register-2.html"> Register 2 </a>
                        </li>
                        <li class="nav-item ${pageContext.request.requestURI.endsWith('lock-screen.html') ? 'active' : ''}">
                            <a class="nav-link" href="pages/samples/lock-screen.html"> Lockscreen </a>
                        </li>
                    </ul>
                </div>
            </li>

            <li class="nav-item ${pageContext.request.requestURI.contains('documentation') ? 'active' : ''}">
                <a class="nav-link" href="documentation/documentation.html">
                    <i class="mdi mdi-file-document-box-outline menu-icon"></i>
                    <span class="menu-title">Documentation</span>
                </a>
            </li>
        </ul>
    </nav>