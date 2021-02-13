
//errors
import Error404 from './errors/Error404';

//Home
import Home from './home/Home';

//dashboard
import Dashboard from './dashboard/Dashboard';

//Users actions
import Login from './user/Login';

//Password related
import ForgotPassword from './password/ForgotPassword';
import ChangePassword from './password/ChangePassword';

//exports
export const error404 = Error404; 
export const home = Home; 
export const login = Login; 
export const forgotPassword = ForgotPassword; 
export const changePassword = ChangePassword; 
export const dashboard = Dashboard; 