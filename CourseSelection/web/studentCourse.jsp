<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@include file="header.jsp"%>
<%@include file="navbar.jsp"%>
<%@include file="sidebar.jsp"%>

<!-- partial -->
<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">

            <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">班级</h4>
                        <p class="card-description"></p>
                        <form action="/StudentCourseServlet" role="form" method="post">
                            <div class="form-group">
                                <label>学年度</label>
                                <select class="form-control form-control-lg" name="year">
                                    <option value="2021">2021-2022</option>
                                    <option value="2022">2022-2023</option>
                                    <option value="2023">2023-2024</option>
                                    <option value="2024">2024-2025</option>
                                    <option value="2025">2025-2026</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>学期</label>
                                <select class="form-control form-control-lg" name="semester">
                                    <option value="1">第一学期</option>
                                    <option value="2">第二学期</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>起始周</label>
                                <select class="form-control form-control-lg" name="week">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                </select>
                            </div>
                            <input type="submit" value="GO" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">
                        </form>

                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th width="12.5%">

                                    </th>
                                    <th width="12.5%">
                                        星期一
                                    </th>
                                    <th width="12.5%">
                                        星期二
                                    </th>
                                    <th width="12.5%">
                                        星期三
                                    </th>
                                    <th width="12.5%">
                                        星期四
                                    </th>
                                    <th width="12.5%">
                                        星期五
                                    </th>
                                    <th width="12.5%">
                                        星期六
                                    </th>
                                    <th width="12.5%">
                                        星期日
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="sc" items="${StudentCourses}">
                                <tr height="70px">
                                    <td align="center" wideth="12.5%">
                                            ${sc.cName}
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>



                                </c:forEach>
                                <tr height="70px">
                                    <td align="center" wideth="12.5%">
                                        第三节 - 第四节
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>

                                <tr height="70px">
                                    <td align="center" wideth="12.5%">
                                        第五节 - 第六节
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>

                                <tr height="70px">
                                    <td align="center" wideth="12.5%">
                                        第七节 - 第八节
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>

                                <tr height="70px">
                                    <td align="center" wideth="12.5%">
                                        第九节 - 第十节
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>

                            </table>
                        </div>
                    </div>
                </div>
            </div>

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
<%@include file="footer.jsp"%>