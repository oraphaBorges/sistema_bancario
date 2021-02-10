import { footer as Footer } from '../../components/index';

let Transaction = {
    is_private: true,
    
    render: async () => {
        let view = `
            <h1>Here is Transaction page :)</h1>
            ${await Footer}
        `;

        return view
    },

    after_render: async () => {

    }
}

export default Transaction;