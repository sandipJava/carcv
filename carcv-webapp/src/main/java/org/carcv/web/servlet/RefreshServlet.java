/*
 * Copyright 2013 CarCV Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.carcv.web.servlet;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.carcv.web.beans.RecognizerBean;

/**
 * A Servlet that calls {@link RecognizerBean#recognize()} and redirects back to referrer.
 */
@WebServlet("/servlet/RefreshServlet")
public class RefreshServlet extends HttpServlet {

    private static final long serialVersionUID = -235344099282905675L;

    @EJB
    private RecognizerBean recognizerBean;

    private ExecutorService pool;

    @Override
    public void init() {
        pool = Executors.newFixedThreadPool(2);
    }

    /**
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
        IOException {
        pool.execute(new RecognizeRunnable());
        response.sendRedirect("/app/refresh_in_progress.jsp");
        return;
    }

    /**
     * @see #processRequest(HttpServletRequest, HttpServletResponse)
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see #processRequest(HttpServletRequest, HttpServletResponse)
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    class RecognizeRunnable implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("[RefreshServlet]\tStarting recognizing...");
                recognizerBean.recognize();
                System.out.println("[RefreshServlet]\tDone recognizing! Redirecting...");
            } catch (IOException e) {
                System.err.println("Error during refreshing and recognizing occured!");
                e.printStackTrace();
            }
        }
    }
}