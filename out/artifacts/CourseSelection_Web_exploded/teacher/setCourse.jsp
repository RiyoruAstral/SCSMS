<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@include file="../header.jsp"%>
<%@include file="../navbar.jsp"%>
<%@include file="../sidebar.jsp"%>

<!-- partial -->
<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">
            <div class="col-md-12">
                <h4 class="card-title text-primary">${setCourseMsg}</h4>
            </div>
            <c:forEach items="${teacherCourses}" var="tc">
            <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">课程:${tc.CName} ${tc.year}学年 第${tc.semester}学期 最大人数:${tc.totalPeople} 已选人数:${tc.totalPeople - tc.remainPeople}</h4>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th width="12.5%">
                                        学生号
                                    </th>
                                    <th width="12.5%">
                                        学生姓名
                                    </th>
                                    <th width="12.5%">
                                        成绩
                                    </th>
                                    <th width="12.5%">
                                        提交
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${studentCourses}" var="sc">
                                        <c:if test="${tc.cno == sc.cno}">
                                            <tr>
                                                <td>${sc.sno}</td>
                                                <td>${sc.SName}</td>
                                                <form action="/SetCourseServlet?action=update&year=2025" method="post" class="d-inline">
                                                <td>

                                                    <input value="${sc.grade}"
                                                           name="newGrade"
                                                           type="number"
                                                           min="0"
                                                           max="100"
                                                           step="1"
                                                           class="form-control grade-input">
                                                </td>
                                                <td>
                                                    <input type="hidden" name="sno" value="${sc.sno}">
                                                    <input type="hidden" name="cno" value="${sc.cno}">
                                                    <input type="hidden" name="oldGrade" value="${sc.grade}">
                                                    <button type="submit" class="btn btn-primary btn-sm">提交</button>

                                                </td>
                                                </form>
                                            </tr>
                                        </c:if>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer">
                        <form action="/SetCourseServlet?action=delete&year=2025" method="post" type="form">
                            <input type="hidden" name="cno" value="${tc.cno}">
                            <input type="hidden" name="tno" value="${tc.tno}">
                            <input type="hidden" name="dname" value="${tc.DName}">
                            <button type="submit" class="btn btn-danger btn-sm">删除该课程</button>
                        </form>
                    </div>
                </div>
            </div>

            </c:forEach>
        </div>
    </div>
    <!-- content-wrapper ends -->
    <!-- partial:../../partials/_footer.html -->
    <footer class="footer">
        <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © <a target="_blank"
                                                                                                       href="http://www.mobanwang.com/" title="网页模板">网页模板</a>. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i
                    class="mdi mdi-heart text-danger"></i></span>
        </div>
    </footer>
    <!-- partial -->
<%@include file="../footer.jsp"%>