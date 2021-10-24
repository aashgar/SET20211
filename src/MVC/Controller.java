/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

/**
 *
 * @author aashgar
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String updateView() {
        return this.view.show(this.model.getName(),
                this.model.getMajor(),
                this.model.getGrade());
    }
}
