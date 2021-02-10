import { footer as Footer } from '../../components/index';

let ForgotPassword = {
    is_private: false,

    render: async () => {
        let view = `
            <h1>Here is ForgotPassword page :)</h1>
            ${await Footer}
        `;

        return view
    },

    after_render: async () => {

    }
}

export default ForgotPassword;