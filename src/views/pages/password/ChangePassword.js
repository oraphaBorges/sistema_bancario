import { footer as Footer } from '../../components/index';

let ChangePassword = {
    is_private: true,

    render: async () => {
        let view = `
            <h1>Here is ChangePassword page :)</h1>
            ${await Footer}
        `;

        return view
    },

    after_render: async () => {

    }
}

export default ChangePassword;