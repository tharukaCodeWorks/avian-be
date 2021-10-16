package lk.teachmeit.boilerplate.controller;
/*
 * Author: Tharuka Lakshan Dissanayake
 * Date: 2020/12/04
 */

import lk.teachmeit.boilerplate.dto.ResponseWrapper;

import javax.servlet.http.HttpServletRequest;

public interface IController<T> {
    ResponseWrapper create(T item, HttpServletRequest request);
    ResponseWrapper update(T item, HttpServletRequest request);
    ResponseWrapper deleteById(long id, HttpServletRequest request);
    ResponseWrapper getById(long id, HttpServletRequest request);
    ResponseWrapper getAll(HttpServletRequest request);
}
