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
    it '明細が出力される' do
      get '/api/statement'
      expect(last_response).to be_ok
      json_result = JSON.parse(last_response.body)
      expect(json_result["statement"]).to eq("山田様のレンタル明細\n\t新作\t900円\n\t子供\t150円\n\t一般\t200円\n合計金額 1250円\n獲得ポイント 4ポイント")
    end
  end
end