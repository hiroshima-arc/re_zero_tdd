require_relative './spec_helper'

describe 'Video Rental Statement Service' do
  include Rack::Test::Methods

  before do
    # Do nothing
  end

  after do
    # Do nothing
  end

  context 'statement' do
    it 'テキスト明細が出力される' do
      get '/api/text-statement'
      expect(last_response).to be_ok
      json_result = JSON.parse(last_response.body)
      expect(json_result["statement"]).to eq("山田様のレンタル明細\n\t新作\t900円\n\t子供\t150円\n\t一般\t200円\n合計金額 1250円\n獲得ポイント 4ポイント")
    end
    it 'HTML明細が出力される' do
      get '/api/html-statement'
      expect(last_response).to be_ok
      json_result = JSON.parse(last_response.body)
      expect(json_result["statement"]).to eq("<h1><em>山田様</em>のレンタル明細</h1><p>\n\t新作\t900円<br>\n\t子供\t150円<br>\n\t一般\t200円<br>\n<p>合計金額 <em>1250円</em><p>\n獲得ポイント <em>4ポイント</em><p>")
    end
  end
end